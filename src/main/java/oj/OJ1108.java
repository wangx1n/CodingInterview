package oj;

/**
 * @program: CodingInterview
 * @description:
 * @author: wang xin
 * @create: 2021/3/23 14:38
 **/
public class OJ1108 {
    public String defangIPaddr(String address) {
        char[] addressChars = address.toCharArray();
        char[] FaultAddressChars = new char[address.length()*3];
        StringBuffer buffer = new StringBuffer(address.length()*3);

        for(int i=0;i< addressChars.length;i++){
            if(addressChars[i] == '.'){
                buffer.append("[.]");
            }else{
                buffer.append(addressChars[i]);
            }
        }
        return buffer.toString();
    }
}

