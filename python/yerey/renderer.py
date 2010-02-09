import Image
import colorsys

def printSimple(terrain):
    print [x for x in terrain]
    
def printPlain(terrain):
    for row in terrain:
        print ["%.1f" % cell for cell in row]

def printRGB(rgb):
    for row in rgb:
        print ["%3d,%3d,%3d" % cell for cell in row]

def image(rgb):
    size = len(rgb)
    im = Image.new("RGB", (size, size))
    data=[]
    for row in rgb:
        for val in (row):
            data.append(val)
    im.putdata(data)
    return im

WATER_LEVEL = 0.8
WATER_COLOR = (50, 66, 120)

def greyscale(terrain):
    return [[(int(255*val), int(255*val),int(255*val)) for val in row] for row in terrain]
    
def greenfield(terrain):
    return [[(60, int(255*val), 0) if val < WATER_LEVEL else WATER_COLOR for val in row] for row in terrain]

def plainground(terrain):
    return [[(int(255*val), int(255*val), int(192*val)) if val < WATER_LEVEL else WATER_COLOR for val in row] for row in terrain]
