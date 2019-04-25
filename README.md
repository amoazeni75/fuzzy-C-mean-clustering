<h1>Fuzzy C-Mean Clustering Algorithm</h1>
<p>in this project we are going to implement fuzzy c-means clustering algorithm in java.
first we are going to give a brief look at the algorithm steps, then dive into details of methods we used.</br>
for more details you can visit this link : https://home.deib.polimi.it/matteucc/Clustering/tutorial_html/cmeans.html</p>
<h1>Fuzzy C-Mean Algorithm Steps</h1>
<ol>
  <li>initial membership</li>
  <li>calculate centroides value</li>
  <li>update membership values</li>
  <li>check convergence</li> 
</ol>
<p>there is a loop berween step 2 til step 4, after specific number of iterations or satisfying error condition the algorithm will be stop.</p>
<h1>Source code guide</h1>
<p> the source code contains a class named "FuzzyClustering" that has some fields and methods, in the below we will give a brief information about them.</br> here is the fields of FuzzyClustering.java class</p>
<dl>
  <dt>U matrix</dt>
  <dd>- matrix of membership values with n * m dimensiones (n = dataset size and m = cluster number size)</dd>
  <dt>iteration</dt>
  <dd>- #iteration that algorithm perform calculation</dd>
  <dt>fuzziness</dt>
  <dd>- value of parameter M in c-mean formula</dd>
  <dt>epsilon</dt>
  <dd>- threshold of error between current membership values and prevoius step</dd>
</dl>
