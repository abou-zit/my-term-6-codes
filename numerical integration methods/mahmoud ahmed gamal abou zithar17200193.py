
# take input from user

a = float(input("please enter the value of A"))

b = int(input("please enter the value of b"))

h = float(input("please enter the value of fixed width (h)"))

# take the type of operation from user(extract input)

the_kind_of_operation = input("enter the type of method if it midpoint or trapzoidial or simpson like this (m,t,s)")

x = [0] * 10

for i in range(5):
    if a <= b:
        x[i] = a
        a += h

for i in range(len(x)):
    print(x[i])

def midpoint(array):
    equation = input("please enter the equations ")

