package com.example.myapplication

import java.util.PriorityQueue


fun main(){


    //merge two sorted linked list
    //https://www.youtube.com/watch?v=f8RPIb-0DDE

    //detect cycle nd remove
    //https://www.youtube.com/watch?v=-1E8ZMS0gSs

    //reverse of linkedlist by shradha khapra
    //https://www.youtube.com/watch?v=R-CKBYnOv1U&t=369s

    //best time to sell stock
    /*var input = arrayOf(7,1,5,3,6,4)
    var minItem = input[0]
    var result = 0
    for(item in input){
        if(item<minItem){
            minItem = item
            result =0
        }
        if(item>result){
            result = item
        }
    }
    println("item "+result)*/

    //Longest Substring Without Repeating Characters
    /*var str = "abcabcbb"
    var strBuilder = StringBuilder()
    var result = ""
    for(item in str){
        if(strBuilder.toString().contains(item)){
            strBuilder.clear()
        }else{
            strBuilder.append(item)
        }
        if(strBuilder.toString().length>result.length){
            result = strBuilder.toString()
        }
    }
    println(result)*/


     //fabonaci series
    /*var limit =10
    var count =0
    var t1=0
    var t2=1
    var sum =0
    while(count<limit){
        println(t1)
        sum = t1+t2
        t1=t2
        t2=sum
        count++
    }*/

    //Prefix String
    /*val input = arrayOf("flow","flower","flish")

    input.sort()

    var str = input[0]
    var strl = input[input.size-1]
    var strLength = str.length
    var strlastLength = strl.length
    var sb = StringBuilder()
    if(str.length>=strl.length){

        for((index,value) in str.withIndex()){
            if(strLength>index && !str[index].equals(strl[index]))
                break;
            sb.append(value)
        }
    }else if(strl.length>str.length){
        for((index,value) in strl.withIndex()){
            if(strlastLength>index && str[index]!=strl[index])
                break;
            sb.append(value)
        }
    }
     println(sb.toString())*/

    //Maximum subarray(Kadance algorithms)
    //https://www.youtube.com/watch?v=9IZYqostl2M&t=1166s
     /*var input = arrayOf(-2,1,-3,4,-1,2,1,-5,4)
     var result = 0
     var finalResult = 0
    for(item in input){
         result = result + item
         if(finalResult<result){
             finalResult = result
         }
        if(result<0){
            result = 0
        }
     }
     println(finalResult)*/

    //sum of two number
    /*var input = arrayOf(2,7,11,15)
    var firstPointer = 0
    var lastPointer = input.size-1
    var target = 9

    for(item in input){
        if(firstPointer<lastPointer){
            var result = input[firstPointer]+input[lastPointer]
            if(result>target){
                lastPointer--
            }else if(result<target){
                firstPointer++
            }else{
                println("target achieved")
                break;
            }
        }
    }*/

    //rotation array
    /*var input = arrayOf(1,2,3,4,5,6,7)
    var target = 3
    reverseItem(input,0,input.size-1)
    reverseItem(input,0,target-1)
    reverseItem(input,target,input.size-1)
    println(input.contentToString())*/

    //kth largest elements
    //https://www.youtube.com/watch?v=tmH8nOmO_m4

    /*var input = arrayOf(3,2,1,5,6,4,9)
    var k = 3
    var priorityQueue = PriorityQueue<Int>()
    for(item in input){
        if(priorityQueue.size<k){
            priorityQueue.add(item)
        }else{
            if(priorityQueue.peek()<item){
                priorityQueue.poll()
                priorityQueue.add(item)
            }
        }
    }
    println(priorityQueue.peek())*/

// group anagrams
    /*var input = arrayOf("eat","tea","tan","ate","nat","bat")
    var result = groupAnagrams(input)
    println(result)*/

    //3rd largest number
    /*var input = arrayOf(3,2,1,5,6,4)
    var target = 3
    var priorityQueue = PriorityQueue<Int>()
    for(item in input){
        if(priorityQueue.size<target){
            priorityQueue.add(item)
        }else{
            if(priorityQueue.peek()<item){
                priorityQueue.poll()
                priorityQueue.add(item)
            }
        }
    }
    println(priorityQueue.peek())*/

    /*var input = intArrayOf(10,5,3,6,8)

    for((index,value) in input.withIndex()){
        for((index1,value) in input.withIndex()){
            if(input[index]>input[index1]){
                var temp = input[index]
                input[index] = input[index1]
                input[index1] = temp
            }
        }
    }
    println(input)*/
}

fun reverseItem(nums: Array<Int>,start1:Int,end1:Int){
   var start =start1
   var end = end1
   while(start<end){
       var temp = nums[start]
       nums[start] = nums[end]
       nums[end] = temp
       start++
       end--
   }
}

fun isPalindromeNumber(num: Int): Boolean {
    var reversed = 0
    var temp = num
    while (temp != 0) {
        reversed = reversed * 10 + (temp % 10)
        temp /= 10
    }
    return num == reversed
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    // Use a HashMap to store the sorted string (key) and a list of anagrams (value)
    val anagramGroups = HashMap<String, MutableList<String>>()

    for (word in strs) {
        // Sort the characters of the word to create a canonical key
        val sortedWordKey = word.lowercase().toCharArray().sorted().joinToString("")

        // Get the existing list for the key, or a new mutable list if it doesn't exist
        val currentGroup = anagramGroups.getOrPut(sortedWordKey) { mutableListOf() }

        // Add the original word to the list
        currentGroup.add(word)
    }

    // Return all the collected groups as a List of Lists
    return anagramGroups.values.toList()
}
