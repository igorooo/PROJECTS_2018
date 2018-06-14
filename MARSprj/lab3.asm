.data
    a: .asciiz "a"
    s: .asciiz "= "
    msg: .asciiz "\nPodaj n: "
    msg1: .asciiz "Dany jest ciag: "
    msg2: .asciiz "\nCzy powtorzyc?  [0] jesli tak: "
    msg3: .asciiz "\nLiczby parzyste:  "
    c: .asciiz ", "
            .align 2
    array: .space 100
   
.text
 
start:
       
    jal input  
       
    jal output
   
    jal displayeven
   
    j again
 
    li $v0, 10
   
   
   
       
again:
    #display "Czy powtorzyc? "
    li $v0, 4
    la $a0, msg2
    syscall
   
   
    li $v0, 5
    syscall
   
    move $t5, $v0
   
    beqz $t5, start
   
   
    jr $ra
   
 
   
#max procedure
displayeven:
   
    #move index and pointer to 0
    li $t1, 1
    li $t2, 0
    li $t6, 2
   
    #display "Liczby parzyste: "
    li $v0, 4
    la $a0, msg3
    syscall
   
   loopd:
    beq $t1, $t0, endd
   
    #Getting val from array
    lw $t3, array($t2)
   
    #Increase index and pointer
    add $t2, $t2, 4
    add $t1, $t1, 1
   
    #divide
    div $t3, $t6
   
    #take reminder
    mfhi $t7
   
    #check, if equal to zero then even
    beqz $t7, display
 
    j loopd
   
   display:
   
    #Display val
    li $v0, 1
    move $a0, $t3
    syscall
   
    #Display ", "
    li $v0, 4
    la $a0, c
    syscall
   
    j loopd
 
   
   endd:
    jr $ra 
                           
   
#input procedure   
input:
 
    li $v0, 4
    la $a0, msg
    syscall
   
    li $v0, 5
    syscall
   
    move $t0, $v0
    add $t0, $t0, 1
   
    #index = $t1, n = $t0, pointer = $t2
    li $t1, 1
    li $t2, 0
 
 
    loopi:
    beq $t1, $t0, endi
   
    #display "a"
    li $v0, 4
    la $a0, a
    syscall
   
    #display index
    li $v0, 1
    move $a0, $t1
    syscall
   
    #display "= "
    li $v0, 4
    la $a0, s
    syscall
   
    #get input
    li $v0, 5
    syscall
   
    #save in array
    sw $v0, array($t2)
   
    #increase pointer and index
    add $t2, $t2, 4
    add $t1, $t1, 1
   
    #loop
    j loopi
 
    endi:  
    jr $ra
   
   
#output procedure
output:
   
    #move index and pointer to 0
    li $t1, 1
    li $t2, 0
   
    #display "Dany jest ciag: "
    li $v0, 4
    la $a0, msg1
    syscall
   
   loopo:
    beq $t1, $t0, endo
   
    #Getting val from array
    lw $t3, array($t2)
   
    #Increase index and pointer
    add $t2, $t2, 4
    add $t1, $t1, 1
   
    #Display val
    li $v0, 1
    move $a0, $t3
    syscall
   
    #Display ", "
    li $v0, 4
    la $a0, c
    syscall
   
    #loop
    j loopo
 
     endo:
    jr $ra