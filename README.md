Team May-Tricks

Alan Wang, Kevin Wang, Kaitlin Wan

APCS2 Pd. 8

L #00 -- But What Does the Data Say?

2018-02-09

# Background

Problem: Devise a O(n) search algorithm for a n x n 2D array of ints, wherein numbers increase across any row (L-> R) and down any column.
# Hypothesis

If there is a n x n 2D array of ints, wherein numbers increase across any row (L-> R) and down any column, then we believe that our algorithm exhibits a O(n) runtime.
![Flow Chart & Procedure for Algorithim](https://github.com/KaitlinWan/May-Tricks/blob/master/Search2DArray.jpg)
# Experiment Methodology

    We are going to find out if our algorithm has a O(n) runtime by testing how long the algorithm takes to run on increasing n values. With this data we are going to graph the points and look at the trend of the graph. In order to time how long the algorithm takes to find the value in the 2D array, we will run `System.currentTimeMillis()` right before starting the algorithm and again when the algorithm just finishes and subtract the two values from each other.
    We will create three different test cases: one when the array has consecutive elements (1, 2, 3, ...) and running the worst case, one when the array has consecutive elements, but with a random target, and a random array with random target. In all of our runs (including the different test cases), we will start with a n value of 5000 and end at 17000, going at increments to 100. To maximize computer performance, we will try our best not to run other programs manually. Furthermore, we will be running 5000 trials so that we get a truer reading, in case that there are outliers. One possible reason could be an element that is found near the beginning while others that are almost worst cases (for the test cases that do not use the worst case). However, of those 5000 trials, we will only be using the latter 4900 because for some reason, runtimes in the beginning take much longer. We will find the total time for the 4900 trials and calculate the average.
# Results

![Array With Consecutive Elements and Random Target](https://github.com/KaitlinWan/May-Tricks/blob/master/consecutive_rand.png)
![Array With Consecutive Elements and Worst Case Target](https://github.com/KaitlinWan/May-Tricks/blob/master/consecutive_worst.png)
![Random Array With Random Target](https://github.com/KaitlinWan/May-Tricks/blob/master/rand_rand.png)

# Conclusion
    From these tests we conclude that this algorithim runs in O(n) runtime. From the results of this lab we can see that the graph closely resembles that of a linear graph.
