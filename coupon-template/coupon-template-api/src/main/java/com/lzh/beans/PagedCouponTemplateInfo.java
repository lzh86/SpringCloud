package com.lzh.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//import javax.validation.constraints.NotNull;

/**
 * 创建优惠券模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedCouponTemplateInfo {

    public List<com.geekbang.coupon.template.api.beans.CouponTemplateInfo> templates;

    public int page;

    public long total;

}
