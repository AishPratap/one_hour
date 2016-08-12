def sum35(num):
	result = 0;
	for i in range(1, num):
		if i % 3 == 0 or i % 5 == 0:
			result += i
	return result

print sum35(1000)
