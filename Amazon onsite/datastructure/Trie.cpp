#include <string>
#include <iostream>
using namespace std;
class Node {
public:
    bool word = false;  // Node's "word" label
    Node* children[26]; // children[0] corresponds to 'a', children[1] to 'b', etc.
    Node();             // Node constructor
};

Node::Node(void) {
for(int i = 0; i < 26; ++i) {
    children[i] = NULL;
}
}

class MultiwayTrie {
public:
    Node* root = new Node();  // root node of Multiway Trie
    bool find(string word);   // "find" function of MultiwayTrie class
    void insert(string word); // "insert" function of MultiwayTrie class
    void remove(string word); // "remove" function of MultiwayTrie class
};

/* Return true if MultiwayTrie contains word, otherwise return false */
bool MultiwayTrie::find(string word) {
    /* YOUR CODE HERE */
    Node* node = root;
    int index = 0;
    while (node != NULL && index < word.size()) {
        Node* temp = root->children[word[index] - 'a'];
        if (temp == NULL) return false;
        if (index == word.size() -1 && temp->word == true) return true;
        node = temp;
        index++;
    }
    return false;
}

/* Insert word into MultiwayTrie (return nothing) */
void MultiwayTrie::insert(string word) {
    /* YOUR CODE HERE */
    Node* node = root;
    for (int  i = 0; i < word.size(); i++) {
        int index = word[i] - 'a';
        Node* next = node->children[index];
        if (next == NULL) {
            next = new Node();
        }
        node = next;
    }
    node->word = true;
}

/* Remove word from MultiwayTrie (return nothing) */
void MultiwayTrie::remove(string word) {
    /* YOUR CODE HERE */
    Node* node = root;
    for (int i = 0; i < word.size(); i++) {
        Node* next = node->children[word[i]-'a'];
        if (next == NULL) break;
        node = next;
    }
    node->word = false;
}

    int main() {
    }
    int main() {
    }