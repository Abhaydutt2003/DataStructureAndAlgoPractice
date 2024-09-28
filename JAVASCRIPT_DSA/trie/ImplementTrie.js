class TrieNode {
  constructor() {
    this.children = new Array(26).fill();
    this.isEnd = false;
  }
}

class Trie {
  constructor() {
    this.root = new TrieNode();
  }
  /**
   *
   * @param {string} word
   * @returns {void}
   */
  insert(word) {
    let currentNode = this.root;
    for (const char of word) {
      if (!currentNode[char.charCodeAt(0) - 97])
        currentNode[char.charCodeAt(0) - 97] = new TrieNode();
      currentNode = currentNode[char.charCodeAt(0) - 97];
    }
    currentNode.isEnd = true;
  }
  /**
   *
   * @param {string} word
   * @returns {boolean}
   */
  search(word) {
    let currentNode = this.root;
    for (const char of word) {
      if (!currentNode[char.charCodeAt(0) - 97]) return false;
      currentNode = currentNode[char.charCodeAt(0) - 97];
    }
    return currentNode.isEnd;
  }

  /**
   *
   * @param {string} word
   * @returns {boolean}
   */
  startsWith(word) {
    let currentNode = this.root;
    for (const char of word) {
      if (!currentNode[char.charCodeAt(0) - 97]) return false;
      currentNode = currentNode[char.charCodeAt(0) - 97];
    }
    return true;
  }
}

