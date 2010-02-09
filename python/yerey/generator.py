from array import array
import random

def fractal(size=512+1):
    ter = empty(size)
    seed(ter, size)
    perform(ter, size)
    return ter
    
def empty(size):
    return [[0.0 for row in range(size)] for col in range(size)]

def perform(terrain, size, x=0, y=0, iteration=0):
    half = size / 2
    xh = x+half
    yh = y+half
    n = size-1
    xn = x+n
    yn = y+n
    
    """diamond"""
    x0y0 = terrain[x][y]
    x0y1 = terrain[x][yn]
    x1y0 = terrain[xn][y]
    x1y1 = terrain[xn][yn]
    x0avg = (x0y0+x0y1)/2
    x1avg = (x1y0+x1y1)/2
    avg = (x0avg+x1avg)/2
    disp = displacement(iteration)
    val = avg+disp
    if (val>1 or val<0):
        val = avg
    terrain[xh][yh]=val
    
    """square"""
    y0avg = (x0y0+x1y0)/2
    y1avg = (x0y1+x1y1)/2
    terrain[xh][y] = y0avg
    terrain[xh][yn]= y1avg
    terrain[x][yh] = x0avg
    terrain[xn][yh]= x1avg
    
    """recursive call"""
    if (half>1):
        iteration = iteration+1
        halfPlus = half+1;
        perform(terrain, halfPlus, x,  y,  iteration)
        perform(terrain, halfPlus, xh, y,  iteration)
        perform(terrain, halfPlus, x,  yh, iteration)
        perform(terrain, halfPlus, xh, yh, iteration)
    
def seed(terrain, size, x=0, y=0):
    n = size-1
    xn = x+n
    yn = y+n
    terrain[x][y] = random.random()
    terrain[x][yn] = random.random()
    terrain[xn][y] = random.random()
    terrain[xn][yn] = random.random()
    
def displacement(i):
    val = random.random()
    val = ((val*2)-1) / (1<<(i+1))
    return val