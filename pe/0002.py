def even_fib(limit):
	pre = 1
	cur = 2
	result = 0
	while (cur <= limit):
		if cur % 2 ==0:
			result += cur
		temp = cur
		cur += pre
		pre = temp
	return result

print even_fib(4000000)


