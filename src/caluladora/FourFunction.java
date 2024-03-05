/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package caluladora;

/**
 *
 * @author kainom
 */
@FunctionalInterface
public interface FourFunction<A,B,C,D> {
    
    void apply(A a, B b, C c, D ...d);
}
