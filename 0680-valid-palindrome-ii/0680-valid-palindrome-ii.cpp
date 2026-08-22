class Solution {
public:
    bool chance;

    bool isA(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    bool isPalindrome0(string s) {
        
        int l = 0, r = s.length()-1;

        
        while(l<r){
           
            char c1 = s[l];
            char c2 = s[r];

            if(isA(c1) && isA(c2)){         
                if(c1 >= 'A' && c1 <= 'Z'){
                    c1 = c1+32;
                }
                if(c2 >= 'A' && c2 <= 'Z'){
                    c2 = c2+32;
                }

                if(c1 != c2) return false;      
                l++; r--;
            }else if(isA(c1)){          
                r--;
            }else if(isA(c2)){          
                l++;
            }else{              
                l++; r--;
            }
        }

        return true;
    }
    bool isPalindrome1(string s){
        
        int l = 0, r = s.length()-1;

       
        while(l<r){
            
            char c1 = s[l];
            char c2 = s[r];

            if(isA(c1) && isA(c2)){        
                if(c1 >= 'A' && c1 <= 'Z'){
                    c1 = c1+32;
                }
                if(c2 >= 'A' && c2 <= 'Z'){
                    c2 = c2+32;
                }
                
                if(c1 != c2) {          
                    if(chance){
                        
                        return isPalindrome0(s.substr(l+1, r - l)) || isPalindrome0(s.substr(l, r - l)) ;
                    }
                    return false;      
                }

                l++; r--;
            }else if(isA(c1)){          
                r--;
            }else if(isA(c2)){          
                l++;
            }else{              
                l++; r--;
            }
        }

        return true;        
    }
    bool validPalindrome(string s) {
        this->chance = true;
        return isPalindrome0(s) || isPalindrome1(s); 
    }
};

