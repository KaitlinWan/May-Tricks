  Team May-Tricks

Alan Wang, Kevin Wang, Kaitlin Wan

APCS2 Pd. 8

L #00 -- But What Does the Data Say?

2018-02-09

# Background

Problem: Devise a O(n) search algorithm for a n x n 2-D array of integers, wherein numbers increase across any row (L -> R) and down any column.
# Hypothesis

If there is a n x n 2-D array of integers, wherein numbers increase across any row (L -> R) and down any column, then we believe that our algorithm exhibits a O(n) runtime.

![Flow Chart & Procedure for Algorithim](https://github.com/KaitlinWan/May-Tricks/blob/master/MatrixFinder/Search2DArray.jpg)
# Experiment Methodology
We are going to find out if our algorithm has a O(n) runtime by testing how long the algorithm takes to run on increasing n values. With this data we are going to graph the points and look at the trend of the graph.

In order to time how long the algorithm takes to find the target in the 2-D array, we will run `System.currentTimeMillis()` right before starting the algorithm and again when the algorithm just finishes and subtract the two values from each other.

We will create three different test cases: one when the array has consecutive elements (1, 2, 3, ...) and running the worst case, one when the array has consecutive elements, but with a random target, and a random array with random target.

In all of our runs in the different test cases, we will start with a n value of 5000 and end at 17000, going at increments of 100. To maximize computer performance, we will try our best not to run other programs manually. Furthermore, we will be running 5000 trials for each run so that we get a more accurate reading, in case that there are outliers. For instance, there could an element that is found near the beginning while another that is almost a worst case (for the test cases that do not use the worst case).

However, of those 5000 trials, we will only be using the latter 4900 because for some reason, runtimes in the beginning take much longer before leveling out. We will find the total time for the 4900 trials and calculate the average. Then we will repeat this many times and take the average for the multiple executions before analyzing.
# Results

![Array With Consecutive Elements and Random Target](https://github.com/KaitlinWan/May-Tricks/blob/master/MatrixFinder/consecutive_rand.png)
![Array With Consecutive Elements and Worst Case Target](https://github.com/KaitlinWan/May-Tricks/blob/master/MatrixFinder/consecutive_worst.png)
![Random Array With Random Target](https://github.com/KaitlinWan/May-Tricks/blob/master/MatrixFinder/rand_rand.png)

# Conclusion
From the data we conclude that this algorithim runs in O(n) runtime because the graphs has a general linear relationship.

However, one thing that we notice is that the first graph looks rather weird as a large portion of the data is above the trend line, then below, and then above again.

Nevertheless, the third graph would be most general because arrays generally would not have consecutive elements and running under the worst case. On the other hand, there is a rather large peak for the largest n and this could have to do with the runtimes that take longer in the beginning, and because the array is much larger, these anomalies take longer to go away.
