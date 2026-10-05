package org.example.CompletableFuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class ApiCallExample {
    record User(String id, String name) {}
    record Order(String orderId, double amount) {}
    record UserReport(String summary, boolean isError) {}

    // --- Core API / Service Methods ---
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ApiCallExample apiCallExample=new ApiCallExample();
        apiCallExample.executeWithCompletableFuture("AA");
    }

    public static User fetchUser(String userId) {
        simulateBlockingIo(200); // 200ms latency
        if ("invalid".equals(userId)) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        return new User(userId, "Alice Smith");
    }

    public static List<Order> fetchOrders(User user) {
        simulateBlockingIo(300); // 300ms latency
        return List.of(
                new Order("ORD-101", 149.99),
                new Order("ORD-102", 49.50)
        );
    }

    public static UserReport generateReport(List<Order> orders) {
        double total = orders.stream().mapToDouble(Order::amount).sum();
        String summary = "Processed %d orders with total: $%.2f".formatted(orders.size(), total);
        return new UserReport(summary, false);
    }

    public static UserReport handleError(Throwable ex) {
        System.err.println("Pipeline failed: " + ex.getMessage());
        return new UserReport("Fallback: Failed to generate report (" + ex.getMessage() + ")", true);
    }

    // Helper to simulate network / database I/O latency
    private static void simulateBlockingIo(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Operation interrupted", e);
        }
    }

    // --- CompletableFuture Approach (Original) ---
    public static CompletableFuture<UserReport> executeWithCompletableFuture(String userId) throws ExecutionException, InterruptedException {
        CompletableFuture<UserReport> response= CompletableFuture
                .supplyAsync(() -> fetchUser(userId))
                .thenCompose(user -> CompletableFuture.supplyAsync(() -> fetchOrders(user)))
                .thenApply(orders -> generateReport(orders))
                .exceptionally(ApiCallExample::handleError);

        System.out.println(response.join());
        return response;
    }

    // --- Virtual Threads Approach (Java 21+) ---
}
