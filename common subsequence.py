def output_alignment(i, j, D, A, B):
    res = [[], []]
    if i == 0 and j == 0:
        return
    if i > 0 and D[i][j] == D[i-1][j]+1:
        output_alignment(i-1, j, D, A, B)
        res[0].append(A[i-1])
        res[1].append("-")
    elif j > 0 and D[i][j] == D[i][j-1]+1:
        output_alignment(i, j-1, D, A, B)
        res[0].append("-")
        res[1].append(B[j-1])
    else:
        output_alignment(i-1, j-1, D, A, B)
        res[0].append(A[i-1])
        res[1].append(B[j-1])

    print(res)


def edit_distance(A, B):
    D = [[0 for i in range(len(B)+1)] for j in range(len(A)+1)]

    for i in range(len(A)+1):
        D[i][0] = i
    for j in range(len(B) + 1):
        D[0][j] = j

    for j in range(1, len(B)+1):
        for i in range(1, len(A)+1):
            insertion = D[i][j-1]+1
            deletion = D[i-1][j]+1
            mismatch = D[i-1][j-1]+1
            match = D[i-1][j-1]
            if A[i-1] == B[j-1]:
                D[i][j] = min(insertion, deletion, match)
            else:
                D[i][j] = min(insertion, deletion, mismatch)

    for i in range(len(D)):
        print(D[i])

    output_alignment(i, j, D, A, B)


if __name__ == "__main__":
    A = "EDITING"
    B = "DISTANCE"
    edit_distance(A, B)
