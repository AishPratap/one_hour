num = 1000
last = 10
result = 0

for i in range(1, num + 1):
	result += (i ** i) % (10 ** last)
	result %= (10 ** last)
print result
