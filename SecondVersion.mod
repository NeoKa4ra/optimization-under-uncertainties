/*********************************************
 * OPL 12.6.0.0 Model
 * My own model
 *********************************************/
 
int n = ...;

/* pre-computations */
execute INITIALIZE {

}  

dvar float+ x[1..n];
dvar float val[1..n];

// objective 
maximize sum(j in 1..n)val[j];

// Contraints 
subject to {
    forall(i in 1..n)(x[i] <= 1);
    forall(j in 1..n) (val[j] <= sum(i in 1..j)( x[i] - (1-x[i])) + sum(i in j..n)( x[i] + (1-x[i]))); //si j2 fold
    forall(j in 1..n) (val[j] <= sum(i in 1..j)( -x[i]*2 - (1-x[i])) + sum(i in j..n)( x[i]*2 + (1-x[i]))); //si j2 raise
}  
 
/* show solution */
execute {
  
}