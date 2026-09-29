# AI Recommendation System

A Java-based content recommendation system developed as **Project 3** of the DecodeLabs Industrial Training Program.

The system takes a user's interests, compares them with the attributes of available learning resources, calculates a similarity score using **Jaccard Similarity**, and displays the most relevant recommendations.

## 🎯 Project Objective

The main objective of this project is to understand the basic logic behind recommendation systems.

The system demonstrates how user preferences can be matched with item attributes to generate personalized recommendations.

## ✨ Features

- Takes user interests as input
- Accepts multiple interests separated by commas
- Converts input to lowercase for consistent matching
- Removes duplicate interests using `Set`
- Matches user interests with item tags
- Calculates Jaccard similarity
- Ranks recommendations from highest to lowest similarity
- Displays the top 3 recommendations
- Shows which interests matched
- Handles invalid or empty input
- Handles cases where no recommendation matches

## 🧠 How It Works

The recommendation process follows this flow:

```text
User Interests
      ↓
Input Processing
      ↓
Preference Matching
      ↓
Jaccard Similarity
      ↓
Ranking
      ↓
Top Recommendations
```

### Example

If the user enters:

```text
AI, Python, Machine Learning
```

The system compares these interests with the tags of available learning resources.

For each item, it finds:

- **Intersection** → common interests
- **Union** → all unique interests from both sets

Then it calculates the similarity score.

## 📐 Jaccard Similarity

The project uses the Jaccard Similarity formula:

```text
Similarity = |Intersection| / |Union| × 100
```

For example:

```text
User Interests:
AI, Python, Machine Learning

Item:
AI, Machine Learning, Algorithms

Common interests:
AI, Machine Learning

Union:
AI, Python, Machine Learning, Algorithms
```

Therefore:

```text
Similarity = 2 / 4 × 100
           = 50%
```

## 📚 Recommendation Dataset

The current system contains learning resources such as:

- AI Fundamentals
- Python for Data Science
- Web Development Basics
- Data Science & Statistics
- Computer Vision with Python
- Algorithm Design

Each resource has a set of related tags.

## 🛠️ Technologies Used

- Java
- Java Collections Framework
- `HashSet`
- `ArrayList`
- `HashMap` concepts
- Jaccard Similarity
- Sorting and Ranking
- Basic Recommendation System Logic

## ▶️ How to Run

### 1. Compile

Open a terminal in the project folder and run:

```bash
javac RecommendationSystem.java
```

### 2. Run

```bash
java RecommendationSystem
```

### 3. Enter Interests

For example:

```text
AI, Python, Machine Learning
```

The system will analyze the preferences and display the top recommendations.

## 🧪 Testing

The system was tested with different types of input:

### Test 1 — Single Interest

Input:

```text
ai
```

Result:

```text
AI Fundamentals
Similarity: 33.33%

Computer Vision with Python
Similarity: 33.33%
```

### Test 2 — No Matching Interest

Input:

```text
photography
```

Result:

```text
No matching recommendations found.
```

### Test 3 — Multiple Interests

Input:

```text
AI, Python, Machine Learning
```

The system generates multiple recommendations and calculates their similarity scores.

## 📁 Project Structure

```text
java-ai-recommendation-system/
│
├── RecommendationSystem.java
├── README.md
└── TESTING.md
```

## 🎓 Learning Outcomes

Through this project, I practiced:

- Java programming
- Sets and collections
- User input processing
- Pattern matching
- Similarity calculation
- Sorting and ranking
- Recommendation system fundamentals
- Handling different input cases

## 🚀 Future Improvements

Possible improvements include:

- Adding more learning resources
- Adding user ratings
- Using weighted preferences
- Adding a graphical user interface
- Storing data in a database
- Adding more advanced recommendation algorithms
- Developing a web-based version

## 👩‍💻 Internship Information

**Program:** DecodeLabs Industrial Training  
**Batch:** 2026  
**Project:** Project 3 — AI Recommendation Logic  
**Technology:** Java

This project was developed as part of my hands-on Artificial Intelligence learning journey at DecodeLabs.

## 📌 Conclusion

This project demonstrates the fundamental idea behind a content-based recommendation system: comparing user preferences with item attributes and using similarity scores to identify relevant recommendations.

It helped me understand how simple algorithmic logic can be used to create personalized recommendations.
