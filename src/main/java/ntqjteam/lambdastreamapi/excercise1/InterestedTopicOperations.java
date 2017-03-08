package ntqjteam.lambdastreamapi.excercise1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by toan on 3/1/17.
 */
public class InterestedTopicOperations {

    public static void main(String[] args) {

        List<Topic> currentTopics = initCurrentTopics(); // needs initializing
        List<Topic> updatingTopics = initUpdatingTopics();// needs initializing

        // Find out these groups of topics from currentTopics and updatingTopics
        List<Topic> addedTopics = updatingTopics.stream()
                .filter(updatingTopic -> !currentTopics.contains(updatingTopic)).collect(Collectors.toList());
        List<Topic> updatedTopics = updatingTopics.stream()
                .filter(updatingTopic -> currentTopics.contains(updatingTopic)).collect(Collectors.toList());
        List<Topic> deletedTopics = currentTopics.stream()
                .filter(currentTopic -> !updatingTopics.contains(currentTopic)).collect(Collectors.toList());

    }

    private static List<Topic> initUpdatingTopics() {
        return initTopics(new Topic("5", "jav5", "say something about java 5"),
                new Topic("7", "jav6", "say something about java 6"),
                new Topic("3", "jav10", "say something about java 10"),
                new Topic("4", "jav11", "say something about java 11"));
    }

    private static List<Topic> initCurrentTopics() {
        return initTopics(new Topic("1", "jav8", "say something about java 8"),
                new Topic("2", "jav9", "say something about java 9"),
                new Topic("3", "jav10", "say something about java 10"),
                new Topic("4", "jav11", "say something about java 11"));
    }

    private static List<Topic> initTopics(Topic... topics) {
        return Arrays.asList(topics);
    }

}
