import heapq

class MedianFinder:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.low_heap = []
        self.high_heap = []

    def addNum(self, num: int) -> None:
        heapq.heappush(self.high_heap, num)
        heapq.heappush(self.low_heap, -heapq.heappop(self.high_heap))
        if len(self.low_heap) > len(self.high_heap):
            heapq.heappush(self.high_heap, -heapq.heappop(self.low_heap))

    def findMedian(self) -> float:
        if len(self.low_heap) == len(self.high_heap):
            return (self.high_heap[0] - self.low_heap[0]) / 2
        else:
            return self.high_heap[0]

if __name__ == "__main__":
    medianFinder = MedianFinder()
    medianFinder.addNum(2)
    medianFinder.addNum(3)
    print(medianFinder.findMedian())
    medianFinder.addNum(4)
    print(medianFinder.findMedian())