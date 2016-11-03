def largest_factor(num):
	factor = 2
	while num > 1:
		if num % factor ==0:
			num /= factor
		else:
			factor += 1
	return factor

print largest_factor(600851475143)