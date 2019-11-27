def is_palindrome(word):
    word = word.lower()
    i = len(word)-1
    norm = [i]
    back = [i]
    j = 0
    while (i>=0):
        back.append(word[i])
        norm.append(word[j])
        j = j + 1
        i = i - 1
    if (norm == back):
        return True
    else:
        return False
print(is_palindrome('Hannah'))
print(is_palindrome('Deleveled'))
print(is_palindrome('Dad'))
print(is_palindrome('Peter'))