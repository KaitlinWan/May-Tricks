Team May-Tricks                            
Alan Wang, Kevin Wang, Kaitlin Wan                        
APCS2 pd08                                                    
L #00 -- But What Does the Data Say?                                                  
2018-02-08                                                 

# Hypothesis
If there is a n x n 2D array of ints, wherein numbers increase across any row (L->R) and down any column then we believe that our algorithm exhibits a O(n) runtime. 
# Background
Problem: Devise a O(n) search algorithm for a n x n 2D array of ints, wherein numbers increase across any row (L->R) and down any column.
![Flow Chart & Procedure for Algorithim](https://github.com/KaitlinWan/May-Tricks/blob/master/Search2DArray.jpg)
# Experiment Methodology
We are going to find out if our algorithm is a O(n) runtime by testing how long the algorithm takes to run on increasing n values, with this data we are going to graph the points and look at the trend of the graph. In order to time how long the algorithm takes to find the value in the 2D array we will run System.out.currentTimeMillis() when starting the algorithm and System.out.currentTimeMillis() when the algorithm finishes and subtracting the two values from each other. In all of our test cases our value of n will be greater than 1000 to minimize the effect of other variables affecting our experiment (Computer Memory Management). Furthermore, we will be running multiple trials for the same purpose of minimizing the effects of outside variables and to minimize the probabilty that the value we are trying to find just so happened to be a value that drastically lowered or increased the time; in other words a value that is found in the beginning of the 2-D array or a value at the end of the 2-D array.
# Results

![Ordered Random](https://rgithub.com/KaitlinWan/May-Tricks/blob/master/Ordered%20Random.png)
![Worst Case](https://github.com/KaitlinWan/May-Tricks/blob/master/Worst%20Case.png)
![Ordered Target](https://github.com/KaitlinWan/May-Tricks/blob/master/Ordered%20Target.png)


# Conclusions
From these tests we conclude that this algorithim runs in O(n) runtime. From the results of this lab we can see that the graph closely resembles that of a linear graph. 
