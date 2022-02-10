package me.xueyao.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

/**
 * @author Simon.Xue
 * @date 2020-03-03 20:26
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageResult<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer count;
    private T result;

    public PageResult(T data, Page page) {
        this.result = data;
        this.pageNum = page.getNumber() + 1;

        this.pageSize = page.getSize();
        this.count = Integer.valueOf(String.valueOf(page.getTotalElements()));
    }
}
