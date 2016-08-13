def div(num):
	count = 0
	for i in range(1, num + 1):
		if num % i == 0:
			print i
			count += 1
	return count

div(1800)