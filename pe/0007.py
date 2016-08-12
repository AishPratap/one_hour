size = 104744
prime = [True] * size

for i in range(2, size):
	if prime[i]:
		start = i ** 2
		for j in range(start, size, i):
			prime[j] = False

def fib(index):
	for i in range(2, size):
		if prime[i]:
			index -= 1
			if index == 0:
				return i
	return -1

print fib(10001)	
