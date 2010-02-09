from yerey import renderer, generator as gen
import cProfile

print("generate...")
f = gen.fractal(512+1)
print("render...")
grey = renderer.plainground(f)
print("save...")
renderer.image(grey).save("test.png")
