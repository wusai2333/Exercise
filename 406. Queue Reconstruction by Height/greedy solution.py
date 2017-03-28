# Pick out tallest group of people and sort them in a subarray(S). Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
# For 2nd tallest group(and the rest), insert each one of them into(S) by k value. So on and so forth.
# E.g.
# input: [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
# subarray after step 1: [[7, 0], [7, 1]]
# subarray after step 2: [[7, 0], [6, 1], [7, 1]]


class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if not people:
            return []

        # obtain every people's info
        # key = height, value = k-value,  index in original array
        peopledict, height, res = {}, [], []
        for i in range(len(people)):
            p = people[i]
            if p[0] in peopledict:
                peopledict[p[0]] += (p[1], i),
            else:
                peopledict[p[0]] = [(p[1], i)]
                height += p[0],

        height.sort()

        for h in height[::-1]:
            peopledict[h].sort()
            for p in peopledict[h]:
                res.insert(p[0], people[p[1]])

        return res
