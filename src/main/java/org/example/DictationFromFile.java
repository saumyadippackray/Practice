package org.example;

import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.protobuf.ByteString;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Tests running a dictation grammar against input from a wave file.
 */
public class DictationFromFile {

    public static void main(String[] args) {
        String audioFilePath = "C:/Users/saumy/Downloads/harvard.wav";

        try (SpeechClient speechClient = SpeechClient.create()) {
            // Read the audio file into a byte array
            ByteString audioBytes = ByteString.readFrom(new FileInputStream(audioFilePath));

            // Configure the request
            RecognitionConfig recognitionConfig = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16) // Adjust if using different encoding
                    .setSampleRateHertz(16000) // Adjust based on your audio file
                    .setLanguageCode("en-US") // Set the language
                    .build();

            RecognitionAudio recognitionAudio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes)
                    .build();

            // Perform speech recognition
            RecognizeResponse recognizeResponse = speechClient.recognize(recognitionConfig, recognitionAudio);

            // Process the response
            for (SpeechRecognitionResult result : recognizeResponse.getResultsList()) {
                for (SpeechRecognitionAlternative alternative : result.getAlternativesList()) {
                    System.out.printf("Transcript: %s%n", alternative.getTranscript());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try{
//        Configuration configuration = new Configuration();
//        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
//        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
//        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
//
//        StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
//
//        InputStream stream = new FileInputStream("C:/Users/saumy/Downloads/harvard.wav");
//        recognizer.startRecognition(stream);
//
//        SpeechResult result;
//        String speech="";
//        while ((result = recognizer.getResult()) != null) {
//            speech=speech+result.getHypothesis();
//            System.out.println( result.getHypothesis());
//        }
//        System.out.println(speech);
//        recognizer.stopRecognition();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
}
    }
