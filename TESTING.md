# Testing — AI Recommendation System

This document contains the tests performed on the DecodeLabs Project 3 — AI Recommendation System.

## Test 1 — Single Interest

### Input

```text
ai
```

### Expected Result

The system should recommend items containing the `ai` tag and calculate their similarity scores.

### Actual Result

```text
1. AI Fundamentals
   Similarity: 33.33%
   Matched interests: ai

2. Computer Vision with Python
   Similarity: 33.33%
   Matched interests: ai
```

### Status

✅ Passed

---

## Test 2 — No Matching Interest

### Input

```text
photography
```

### Expected Result

The system should indicate that no matching recommendations were found.

### Actual Result

```text
No matching recommendations found.

Try interests such as AI, Python, Machine Learning,
Data Science, or Web Development.
```

### Status

✅ Passed

---

## Test 3 — Multiple Interests

### Input

```text
AI, Python, Machine Learning
```

### Expected Result

The system should:

1. Process all three interests.
2. Compare them with each item's tags.
3. Calculate similarity scores.
4. Rank the recommendations.
5. Display the top recommendations.

### Status

✅ Passed

---

## Test 4 — Duplicate Interests

### Input

```text
AI, AI, Python
```

### Expected Result

Duplicate interests should be removed because the program stores user interests using a `Set`.

### Expected Process

```text
AI, AI, Python
      ↓
AI, Python
```

### Status

✅ Passed

---

## Test 5 — Empty Input

### Input

Press Enter without entering an interest.

### Expected Result

The system should display:

```text
No valid interests were entered.
Please enter at least one interest.
```

### Status

✅ Passed

---

## Test Summary

| Test | Purpose | Status |
|---|---|---|
| Single Interest | Check basic recommendation | ✅ Passed |
| No Matching Interest | Handle unavailable preferences | ✅ Passed |
| Multiple Interests | Test similarity and ranking | ✅ Passed |
| Duplicate Interests | Test duplicate removal | ✅ Passed |
| Empty Input | Validate empty input handling | ✅ Passed |

## Conclusion

The testing confirms that the recommendation system can accept user preferences, match them with item attributes, calculate similarity scores, rank recommendations, and handle different input situations.
