public boolean isBinaryTree(TreeNode[] nodes) {
		Set<TreeNode> s = new HashSet<>();
		for (TreeNode node : nodes) {
			s.add(node);
		}

		for (TreeNode node : nodes) {
			if (node.left != null) {
				if (!s.contains(node.left)) {
					return false;
				}
				s.remove(node.left);
			}
			if (node.right != null) {
				if (!s.contains(node.right)) {
					return false;
				}
				s.remove(node.right);
			}
		}

		if (s.size() != 1) {
			return false;
		}
		return traverse(s.iterator().next(), s.size());
	}

	private boolean traverse(TreeNode root, int n) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		Set<TreeNode> visited = new HashSet<>();
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			n--;
			visited.add(cur);
			if (cur.left != null) {
				if (visited.contains(cur.left)) {
					return false;
				}
				q.add(cur.left);
			}
			if (cur.right != null) {
				if (visited.contains(cur.right)) {
					return false;
				}
				q.add(cur.right);
			}
		}
		
		return n == 0;
	}
