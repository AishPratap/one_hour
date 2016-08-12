def is_pal(num):
	ori = num
	rev = 0
	while num > 0:
		digit = num % 10
		rev = rev * 10 + digit
		num /= 10
	return rev == ori

def max_pal(digit):
	val = 10 ** digit
	max_val = 0
	begin = val * 2/3;
	for i in range(val, begin - 1, -1):
		for j in range(val, i - 1, -1):
			cur = i * j
			if is_pal(cur) and max_val < cur:
				max_val = cur
	return max_val

print max_pal(3)

