#include <iostream>
#include <stack>

using namespace std;

int main()
{

    int i,n,t,temp;
    int *pseq,*wseq;


    cin>>t;

    while(t--){

        temp = 1;
        stack<int> s;
        cin>>n;

        pseq = new int[n];
        wseq = new int[n];


        for(i = 0;i < n; i++){
            cin>>pseq[i];

            while(temp < pseq[i]){
                s.push(temp);
                temp++;
            }

            if( i == 0){
                wseq[i] = 1;
            }

            if( i > 0 ){

                if(pseq[i] > pseq[i-1]){
                    wseq[i] = 1;
                }
                if(pseq[i] == pseq[i-1]){
                    wseq[i] = pseq[i] - s.top() + 1;
                    s.pop();
                }
            }
            temp = pseq[i] + 1;
        }

        for(i = 0; i < n; i++){
            cout<<wseq[i]<<" ";
        }
        cout<<endl;

    }

    return 0;
}
