def extract(num):
    result = {}
    factor = 2
    counter = 0
    while (num > 1):
        if num % factor == 0:
            num /= factor
            counter += 1
        else :
            if counter > 0:
                result[factor] = counter
            factor += 1
            counter = 0
        if counter > 0:
            result[factor] = counter
    return result

def min_mul(limit):
    factors = {}
    for i in range(2, limit + 1):
        cur_map = extract(i)
        for key, val in cur_map.iteritems():
            cur_val = factors.get(key, 0)
            factors[key] = max(cur_val, val);
    result = 1
    for key, val in factors.iteritems():
        result *= (key ** val)
    return int(result)

print min_mul(20)