package Assignment;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {

    public static void main(String[] args) {

        List<Candidate> candidateList = InterviewRepository.getCandidateList();

        System.out.println("list candidate names from Pune city");
        candidateList.stream()
                .filter(candidate -> candidate.getCity().equalsIgnoreCase("pune"))
                .forEach(System.out::println);
        System.out.println("================================================================================");

        System.out.println("Candidate count per city");
        candidateList.stream().
                collect(Collectors.groupingBy(Candidate::getCity, HashMap::new,
                        Collectors.counting())).forEach((city, count) ->
                        System.out.println("city: " + city + "--" + "count: " + count));
        System.out.println("================================================================================");

        System.out.println("Candidate count by Technical Expertise");
        candidateList.stream()
                .collect(Collectors.groupingBy(Candidate::getTechnicalExpertise, HashMap::new,
                        Collectors.counting())).forEach((expertise, count) ->
                        System.out.println("Technical Expertise : " + expertise + "---" + "Count : " + count));
        System.out.println("================================================================================");

        System.out.println("Fresher Candidate list");

        candidateList.stream()
                .filter(candidate -> candidate.getYearsOfExperience() < 1)
                .forEach(System.out::println);

        System.out.println("================================================================================");

        System.out.println("Sorted List of Candidates by Experience");

        candidateList.stream().sorted((o1, o2) -> o2.getYearsOfExperience() - o1.getYearsOfExperience())
                .forEach(System.out::println);

        System.out.println("================================================================================");

        System.out.println("Sorted List of Candidates by City Name");


        candidateList.stream()
                .sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity()))
                .forEach(System.out::println);
        System.out.println("================================================================================");




    }

}
