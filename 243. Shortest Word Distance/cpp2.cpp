<<<<<<< HEAD
class Solution {
public:
    int shortestDistance(vector<string>& words, string word1, string word2) {
        int p1 = -1, p2 = -1, res = words.size();
        int minDist = INT_MAX;
        for (int i = 0; i < words.size();i++) {
            if(words[i].compare(word1)==0) {
                p1 = i;
                if(p2 != -1)
                    minDist = min(minDist, p1 - p2);
            } else if (words[i].compare(word2)==0) {
                p2 = i;
                if (p1 != -1)
                    minDist = min(minDist, p2 - p1);
            }
        }
        return minDist;
    }
=======
class Solution {
public:
    int shortestDistance(vector<string>& words, string word1, string word2) {
        int p1 = -1, p2 = -1, res = words.size();
        int minDist = INT_MAX;
        for (int i = 0; i < words.size();i++) {
            if(words[i].compare(word1)==0) {
                p1 = i;
                if(p2 != -1)
                    minDist = min(minDist, p1 - p2);
            } else if (words[i].compare(word2)==0) {
                p2 = i;
                if (p1 != -1)
                    minDist = min(minDist, p2 - p1);
            }
        }
        return minDist;
    }
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
};