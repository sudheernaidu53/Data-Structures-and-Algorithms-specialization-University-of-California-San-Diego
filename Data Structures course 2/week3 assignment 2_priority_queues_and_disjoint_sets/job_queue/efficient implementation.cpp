/*राधे कृष्णा*//*राधे कृष्णा*//*राधे कृष्णा*//*राधे कृष्णा*/
#include <iostream>
#include<string>
#include<map>
#include<queue>
#include<algorithm>
#include <cstdio> 
#include <string> 
#include <vector> 
#include<bits/stdc++.h>
#include<queue>
using namespace std;
#define fastio ios_base::sync_with_stdio(false);cin.tie(NULL);cout.tie(NULL);
//#define test ll t;cin >> t;while(t--)
#define ll long long int
#define  sll stack<ll>
#define  qll queue<ll>
#define  pll pair<ll,ll>
#define  vll vector<ll>
#define  vpi vector<pair<int,int>>
#define f first
#define s second
#define mp make_pair
#define pb push_back
#define ppb pop_back
#define ln "\n"
#define fabl(i,a,b) for(i=a;i<b;i++)
#define fabe(i,a,b) for(i=a;i<=b;i++)
#define fre(i,a,b) for(i=b;i>=a;i--)
void swap(int *a,int *b) {int temp=*a; *a=*b; *b=temp;}
//coursera-job queue
struct pqdata{
    ll key;
    ll val;
};
struct pqcomp{
    bool operator()(pqdata A,pqdata B){
        if(A.key != B.key)
        	return A.key>B.key;
    	else return A.val>B.val;
    }
};
void solve() {
	ll k,n,i,j;
	cin >> k >> n;
	ll a[n];
	//min heap
	priority_queue<pqdata,vector<pqdata>,pqcomp> pq;
	for(i=0;i<n;i++){
		cin >> a[i];
	}
	ll sz=min(k,n);
	for(i=0;i<k;i++){
		pqdata var; var.key=0;var.val=i; 
		pq.push(var);
	}
	for(i=0;i<n;i++){               //as require nlog(n) implementation...take care of using long long!!
		pqdata var;
		var = pq.top();
		pq.pop();
		cout << var.val << " " << var.key << ln;
		var.key+=a[i];
		pq.push(var);
	}
	while(!(pq.empty())){
		pq.pop();
	}
}
int main(){
	fastio
	/*ll t;
	cin >> t;
	while(t--){*/
		solve();
	//}
	return 0;
}
