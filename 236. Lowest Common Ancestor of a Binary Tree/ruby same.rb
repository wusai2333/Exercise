<<<<<<< HEAD
def lowest_common_ancestor(root, p, q)
    return root if [nil, p, q].index root
    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right, p ,q)
    left && right ? root : left || right
end
=======
def lowest_common_ancestor(root, p, q)
    return root if [nil, p, q].index root
    left = lowest_common_ancestor(root.left, p, q)
    right = lowest_common_ancestor(root.right, p ,q)
    left && right ? root : left || right
end
>>>>>>> eb4f20642d79ed3df07dab1830859263475bf5e5
