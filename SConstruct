import os
import buildUtil as util

srcDir = './src'

env = Environment(CCFLAGS='-std=c++0x -g -p -Wall')

binTarget = list()
for fileName in os.listdir(srcDir):
    if fileName.endswith(".cpp"):
        target = env.Program(target = util.genOutName(fileName) + ".out",
            source = srcDir + os.path.sep + fileName)
        binTarget.append(target)
print binTarget

#build and run the unittest cases
testOutList = os.listdir(srcDir)
testList = list()
print testOutList
for fileName in testOutList:
    if util.isOutFile(fileName) is not True:
        continue
    testList.append(testTarget)

def runTest(target, source, env):
    print testList
    for fileName in testList:
        print fileName
        os.system(fileName)

test = Command('test', [], runTest)
Depends(test, binTarget)
