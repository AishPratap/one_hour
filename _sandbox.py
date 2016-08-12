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