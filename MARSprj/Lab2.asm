.data
    r:  .asciiz "\nPodaj promien r: "
    tt: .asciiz " : \n"
    wsp:    .asciiz "Podaj wspolrzedne punktu  "
    x:  .asciiz "x = "
    y:  .asciiz "y =  "
    les:    .asciiz "\nPunkt jest ogrzniczony okregiem "
    eq: .asciiz "\nPunkt lezy na okregu"
    mo: .asciiz "\nPunkt jest poza okregiem"
    ok: .asciiz "\nWczytac nowe parametry okregu? 0 - TAK - "
    repl:   .asciiz "\n\nWczytac nowy punkt? 0 - TAK - "
    wyniki: .asciiz "\n\nWyniki:  "
    msgles: .asciiz "\nPunkt byl ograniczony okregiem:  "
    msgeq:  .asciiz "\nPunkt lezal na okregu: "
    msgmo:  .asciiz "\nPunkt byl poza okregiem: "
.text
       
   
main:
    move $t4, $0  #sum of being less
        move $t5, $0  #sum of being equal
    move $t6, $0  #sum of being bigger
   
    #Display r
    li $v0 4
    la $a0,r
    syscall
   
    #reading R
    li $v0, 5
    syscall
    move $t0, $v0  # $t0 = r
    mul $t0, $t0, $t0
   
    move $t7, $0
   
 
 
next:
 
    #Display wsp
    li $v0 4
    la $a0,wsp
    syscall
   
    li $v0 1
    add $t7, $t7, 1
    move $a0,$t7
    syscall
   
    li $v0 4
    la $a0,tt
    syscall
   
    #Display x
    li $v0 4
    la $a0,x
    syscall
   
    #reading x
    li $v0, 5
    syscall
    move $t1, $v0   #$t1 = x
   
    #Display msg
    li $v0 4
    la $a0,y
    syscall
   
    #reading y
    li $v0, 5
    syscall
    move $t2, $v0  #  $t2 = y
 
    #squares of our numbers
    mul $t1, $t1,$t1
    mul $t2, $t2, $t2
   
    # sum of x & y squares
    move $t3, $0
    add $t3, $t1, $t2  # x^2 + y^2 = $t3
 
    # x^2 + y^2 < r^2
    blt $t3, $t0, less
   
   
    # x^2 + y^2 = r^2
    beq $t3, $t0, equal
 
   
    # then more
    li $v0 4
    la $a0,mo
    syscall
   
    add $t6, $t6, 1
   
    j reply
   
less:
    # display less
    li $v0 4
    la $a0,les
    syscall
   
    add $t4,$t4, 1
   
    j reply
   
equal:
    li $v0 4
    la $a0,eq
    syscall
   
    add $t5,$t5, 1
   
 
reply:
 
    #reply
   
    li $v0, 4
    la $a0,repl
    syscall
   
    li $v0, 5
    syscall
   
    beq $v0, $0, next
   
   
    #display results
    li $v0, 4
    la $a0,wyniki
    syscall
   
    #How many times less than r^2
    li $v0, 4
    la $a0,msgles
    syscall
   
    li $v0, 1
    move $a0,$t4
    syscall
   
    #How many times equal to r^2
    li $v0, 4
    la $a0,msgeq
    syscall
   
    li $v0, 1
    move $a0,$t5
    syscall
   
    #How many times more than r^2
    li $v0, 4
    la $a0,msgmo
    syscall
   
    li $v0, 1
    move $a0,$t6
    syscall
   
    #Display New R
    li $v0 4
    la $a0,ok
    syscall
   
    li $v0, 5
    syscall
   
    beq $v0, $0, main
   
    #end
   
    li $v0, 10
    syscall