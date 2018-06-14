.data
    r:  .asciiz "\ncos tam "
    rr:  .asciiz "\ntam cos "
    rrr:  .asciiz "\ntam cos tam cos "

.text
       
   
main:
    
    li $v0, 4
    la $a0, r
    syscall
    
    jal funct
    
    li $v0, 4
    la $a0, rrr
    syscall
    
    li $v0, 10
    syscall
    
    
funct:
    li $v0, 4
    la $a0, rr
    syscall
    jr $ra
    
   