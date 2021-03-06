package Trie;

import java.util.*;

public class Boggle {

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();

		TrieNode root = buildTrie(words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {

		if (isvalid(board, i, j) == false || p.next[board[i][j] - 'a'] == null) {
			return;
		}

		char c = board[i][j];

		p = p.next[c - 'a'];

		if (p.word != null) { // found one
			res.add(p.word);
			p.word = null; // de-duplicate
		}

		board[i][j] = '#';

		dfs(board, i - 1, j, p, res);
		dfs(board, i, j - 1, p, res);
		dfs(board, i + 1, j, p, res);
		dfs(board, i, j + 1, p, res);

		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();

		for (String w : words) {

			TrieNode p = root;

			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		String word;
		TrieNode[] next = new TrieNode[26];
	}

	private static boolean isvalid(char[][] arr, int i, int j) {

		if (i >= 0 && j >= 0 && i < arr.length && j < arr.length && arr[i][j] != '#')
			return true;

		return false;
	}

	public static void main(String[] args) {
		String[] str = { "oath", "pea", "eat", "rain" };

		char[][] WordBank = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };

		Boggle b = new Boggle();

		System.out.println(b.findWords(WordBank, str));
	}
}