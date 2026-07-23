/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int sizef(ListNode* head){
        int size = 0;
        while(head != NULL){
            size++;
            head = head->next;
        }
        return size;
    }
    ListNode* middleNode(ListNode* head) {
       
        int size = sizef(head);      

        
        int target = size/2;
        ListNode* curr = head;
        for(int i=0; i<target; i++){           
            curr = curr->next;
        }

        
        return curr;    
    }
};

