import java.util.*;

public class RecommendationSystem {

    // Represents a recommended item
    static class Item {
        String name;
        Set<String> tags;

        Item(String name, String... tags) {
            this.name = name;
            this.tags = new HashSet<>(Arrays.asList(tags));
        }
    }

    // Stores a recommendation and its similarity score
    static class Recommendation {
        Item item;
        Set<String> matchedTags;
        double score;

        Recommendation(Item item, Set<String> matchedTags, double score) {
            this.item = item;
            this.matchedTags = matchedTags;
            this.score = score;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create available recommendation items
        List<Item> items = createItems();

        // Display program heading
        printHeader();

        System.out.println("Available interests include:");
        System.out.println("AI, Python, Machine Learning, Data Science,");
        System.out.println("Statistics, Algorithms, Computer Vision,");
        System.out.println("Web Development, HTML, CSS");
        System.out.println();

        // Take user input
        System.out.print("Enter your interests (comma-separated): ");
        String input = scanner.nextLine();

        // Convert input into a Set
        Set<String> userInterests = parseInterests(input);

        // Check empty input
        if (userInterests.isEmpty()) {
            System.out.println("\nNo valid interests were entered.");
            System.out.println("Please enter at least one interest.");

            scanner.close();
            return;
        }

        // Generate recommendations
        List<Recommendation> recommendations =
                generateRecommendations(userInterests, items);

        System.out.println("\nAnalyzing your preferences...");
        System.out.println("User interests: " + formatSet(userInterests));

        System.out.println("\n========== TOP RECOMMENDATIONS ==========");

        int rank = 1;
        boolean foundMatch = false;

        // Display top 3 recommendations
        for (Recommendation recommendation : recommendations) {

            if (recommendation.score > 0) {

                foundMatch = true;

                System.out.println();
                System.out.println(rank + ". "
                        + recommendation.item.name);

                System.out.printf(
                        "   Similarity: %.2f%%%n",
                        recommendation.score
                );

                System.out.println(
                        "   Matched interests: "
                                + formatSet(recommendation.matchedTags)
                );

                rank++;

                if (rank > 3) {
                    break;
                }
            }
        }

        // If no item matches the user's interests
        if (!foundMatch) {

            System.out.println("\nNo matching recommendations found.");

            System.out.println(
                    "Try interests such as AI, Python, "
                            + "Machine Learning, Data Science, "
                            + "or Web Development."
            );
        }

        System.out.println("\n==========================================");
        System.out.println("Recommendation completed successfully.");

        scanner.close();
    }

    // --------------------------------------------------
    // Create recommendation dataset
    // --------------------------------------------------

    static List<Item> createItems() {

        List<Item> items = new ArrayList<>();

        items.add(new Item(
                "AI Fundamentals",
                "ai",
                "machine learning",
                "algorithms"
        ));

        items.add(new Item(
                "Python for Data Science",
                "python",
                "data science",
                "machine learning"
        ));

        items.add(new Item(
                "Web Development Basics",
                "web development",
                "html",
                "css",
                "javascript"
        ));

        items.add(new Item(
                "Data Science & Statistics",
                "python",
                "data science",
                "statistics",
                "machine learning"
        ));

        items.add(new Item(
                "Computer Vision with Python",
                "ai",
                "computer vision",
                "python"
        ));

        items.add(new Item(
                "Algorithm Design",
                "algorithms",
                "data structures",
                "problem solving"
        ));

        return items;
    }

    // --------------------------------------------------
    // Convert user input into a Set
    // --------------------------------------------------

    static Set<String> parseInterests(String input) {

        Set<String> interests = new HashSet<>();

        if (input == null || input.trim().isEmpty()) {
            return interests;
        }

        // Split input using comma
        String[] parts = input.split(",");

        for (String part : parts) {

            // Remove spaces and convert to lowercase
            String interest = part.trim().toLowerCase();

            if (!interest.isEmpty()) {
                interests.add(interest);
            }
        }

        return interests;
    }

    // --------------------------------------------------
    // Generate recommendations
    // --------------------------------------------------

    static List<Recommendation> generateRecommendations(
            Set<String> userInterests,
            List<Item> items) {

        List<Recommendation> recommendations =
                new ArrayList<>();

        for (Item item : items) {

            // Find common interests
            Set<String> intersection =
                    new HashSet<>(userInterests);

            intersection.retainAll(item.tags);

            // Find all unique interests
            Set<String> union =
                    new HashSet<>(userInterests);

            union.addAll(item.tags);

            double score = 0.0;

            // Jaccard Similarity
            if (!union.isEmpty()) {

                score =
                        (intersection.size() * 100.0)
                                / union.size();
            }

            recommendations.add(
                    new Recommendation(
                            item,
                            intersection,
                            score
                    )
            );
        }

        // Sort from highest similarity to lowest
        recommendations.sort((a, b) -> {

            int scoreComparison =
                    Double.compare(b.score, a.score);

            if (scoreComparison != 0) {
                return scoreComparison;
            }

            // If scores are equal, sort by name
            return a.item.name.compareToIgnoreCase(
                    b.item.name
            );
        });

        return recommendations;
    }

    // --------------------------------------------------
    // Format Set for display
    // --------------------------------------------------

    static String formatSet(Set<String> values) {

        List<String> sortedValues =
                new ArrayList<>(values);

        Collections.sort(sortedValues);

        return String.join(", ", sortedValues);
    }

    // --------------------------------------------------
    // Display program heading
    // --------------------------------------------------

    static void printHeader() {

        System.out.println("==========================================");
        System.out.println("       AI RECOMMENDATION SYSTEM");
        System.out.println("       DecodeLabs - Project 3");
        System.out.println("==========================================");
    }
}