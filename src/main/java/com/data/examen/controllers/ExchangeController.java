package com.data.examen.controllers;

import com.data.examen.entity.Exchange;
import com.data.examen.services.ExchangeService;
import com.data.examen.services.ICaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/exchange")
public class ExchangeController {

	@Autowired
	private ExchangeService exchangeService;

	@Autowired
	private ICaptchaService iCaptchaService;
	
	@GetMapping
	public ResponseEntity<?> getAllExchanges(){		
		return ResponseEntity.ok().body(exchangeService.getExchanges());
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<?> getExchange(@PathVariable Long id){
		Optional<Exchange> a = exchangeService.getExchangeById(id);
		if(!a.isPresent())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(a.get());
	}
	
	@PostMapping
	public ResponseEntity<?> saveExchange(@RequestBody Exchange exchange){
		return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.saveExchange(exchange));
	}
	@PostMapping("/captcha")
	public ResponseEntity<Void> validateCaptcha(){
		iCaptchaService.processResponse("03AFcWeA5s5CSaSMmYUxNk8-NMLZTw40jjN7dNfOt82Vtoc_8BGPQcHucfOXsztJM7WXfTvBQkoCMqudb3kD5uVyva1BapGcY9dqMLgVUi2l35h2zAvkjNRKV-CEIZYDg-5qUPbNWJ1MP_gk9tUofkz4tZN3vacEIoTB9BkuT0W-2v5uEebVB2boqN9eV8NWSVG8yAGur0AchOW1mj1vwBnTOvRUOKX_khr0AElP88QQfoV0Btkb5PkKDaWTGFcw-0Eug5arbA40ioxmlBym4vHLIOnoEG9g6UuTW4RThUqrcH47kR8PH-kjtz2Rla_rohrEaKp3FpD0SccR4tvgGtieMKKmCIF2kyMN_9w1ntM5iQq7uyRTwcrd8qUpGfzRIxNLAl6-yGHDZGYh8ljIU2n61G3kSw4KEbcw2Om9cYcWA-NY5_U3T0YVLWWzTINA3_OMUaCGAQQJV1XAAbsNIuU6_lHzgiISVEWCvKm-0y6pNOwNmjtj4h8I8LjLlXsh8VWgT2wNl9zwtCrf31ByWpVXDVTiRzmIyHGeQDDF7Ym0AE62E7cw_r-xptfPmpZ0PctdC161C17W_R5uRnSVnG42ouAoLcOjojPYF-04zU3ceLfBEZALvws27ePCR2FIcopZJ3z3CjvCI7IFSkO4zNaWruxfNMobkooi6JS838R1ycWxQRJmE3CPNUdWx7ZKDr0Wgus0gx1uFRs5mR4cGHOZgD3PCzg7rHVTuAQVoglr0SNA4XcHYWjoVuiBOdtDA50SB9Cn3B2oRY0IdK84MpkHw5wGU4XBOOrfzmRb0x80pSF6nF1ck241lP4igvcyz5_rNkqEbidv5hNKJAMWVDJORZWxjhKTiUa-PkESvCL1S7jDVqJdGXvRvWRcp7PnPohdYBTT7P6Yuu78oHwnymNkqVjbVRwwoYh12YX-HQ1tviAUcRA8nI_96BJPdL3Mr9-S-wdErKQ6jxjU2LbvYMhaBVCL4RQZsPDTl1hmHpsej8h2a585jk9E11HJ1vz2rRr0Lw8M9CqHbb0wgHBuiG5jUaS6YwxTIaAKbKn0Lfxuvb7Ki7ym5Ba_aWwJ0wpFl_z5KHvkhH53zCeRn3fWj4JdYEGY45XFOiIoGP6QZidnF_MeurK7xZJByYqRWBq4sBU8F0nIJ3IffrxliAMSoZcIKpLFtNzHobQaQJnxj92ydu9PiGRv1mhPcqUnRIe8iwTWZ_BmNHtyMkx2iL6pb63zsWyGWwgHqCrtNLE_ENDtNii3aD5P2hBhmD3jXiSOPhTpGQhETr339IrFQYdfWmejzvTQihByzz7noZLij52sPI7z0DWFBR5DWckq0hvkEmePLucNBdQ0C24bWpu8G961_60GNB2kW6S-6HxIBZCnMTXlU9mpNvUgWaQDv7WlWxztjh8lQxqetU42rSnpu72ArzvdsBgINBpEIC5b9ZcLypeqlppO12kjD-P5lWpPKcajshCCCRHrdFazNsfGmWkwFIWMIriMLduWbpUxBF6Oe9-90yYq9V8d-dwxBiGRvey0y5oyuEep82qPFQQM1Nq2iOxFKjVmNKuA");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).<Void>build();
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateExchange(@RequestBody Exchange exchange, @PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(exchangeService.updateExchange(id, exchange));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteExchange(@PathVariable Long id){
		exchangeService.deleteExchange(id);
		return ResponseEntity.noContent().build();
	}	

}
