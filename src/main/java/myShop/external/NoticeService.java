
package myShop.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="notice", url="${api.url.notice}")
public interface NoticeService {

    @RequestMapping(method= RequestMethod.POST, path="/notices")
    public void noticeRequest(@RequestBody Notice notice);

}