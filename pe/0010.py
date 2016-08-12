size = 2000001
prime = [True] * size

for i in range(2, size):
	if prime[i]:
		start = i ** 2
		for j in range(start, size, i):
			prime[j] = False

result = 0
for i in range(2, size):
	if prime[i]:
		result += i
print result