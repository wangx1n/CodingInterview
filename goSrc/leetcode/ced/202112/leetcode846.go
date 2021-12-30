package _02112

func isNStraightHand(hand []int, groupSize int) bool {
	if len(hand) % groupSize != 0 {
		return false
	}
	cntMap := map[int]int{}
}