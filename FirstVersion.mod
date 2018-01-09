/*********************************************
 * OPL 12.6.0.0 Model
 * My own model
 *********************************************/
 
int n = ...;
float c[1..n][1..n] = ...;

/* pre-computations */
execute INITIALIZE {

}  

dvar float val;
dvar float p[1..n];

/* objective */
minimize val ;

/* Contraints */
subject to {
    forall(i in 1..n)(val >= (sum(j in 1..n) c[i][j]*p[j])) ;
    sum(k in 1..n) p[k] == 1;
    forall(k in 1..n) p[k] >=0;
}         
 
/* show solution */
execute {
  
}