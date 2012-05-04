
public class WavelengthToRGB {

	public static int[] convert(float wavelength) {
		double red,green,blue;
		red=0;
		green=0;
		blue=0;

    //Purple color scheme - Meghan

      double milli_wave = wavelength/1000;
      double redshift = milli_wave - 0.4;
		double greenshift = milli_wave - 0.75;
		double blueshift = milli_wave - 0.6;

		red = 10*-(Math.pow(redshift, 2.0)) + 1;
		green = 50*-(Math.pow(greenshift, 2.0)) + 1;
		blue = 35*-(Math.pow(blueshift, 2.0)) + 1;


/* //RGB Color Scheme

		if (wavelength<730f && wavelength >= 670f) {
			red = (730f-wavelength)/(730f-670f);
			green = 0;
			blue = 0;
		}	
		else if (wavelength<670f && wavelength >= 540f) {
			red = 1;
			green = (670f-wavelength)/(670f-540f);
			blue = 0;
		}
		else if (wavelength<=540f && wavelength >= 510f) {
			red = (wavelength-510f)/(540f-510f);
			green = .5f+.5f*(wavelength-510f)/(540f-510f);
			blue = 0;
		}
		else if (wavelength<=510f && wavelength >= 490f) {
			red = 0;
			green = .5f;
			blue = .5f*(510f-wavelength)/(510f-490f);
		}
		else if (wavelength<=490f && wavelength >= 460f) {
			red = 0;
			green = .5f + .5f*(wavelength-490f)/(490f-460f);
			blue = .5f+.5f*(490f-wavelength)/(490f-460f);
		}
		else if (wavelength<=460f && wavelength >= 400f) {
			red = .5f*(460f-wavelength)/(460f-400f);
			green = 0;
			blue = 1;
		}
		else {
			if (wavelength<=400) {
				red = .5f;
				green = 0;
				blue = 1;
			}
			else {
				red = 0;
				green = 0;
				blue = 0;	
			}
		}
		
*/

		return new int[] {(int)(red*255),(int)(green*255),(int)(blue*255)};
	}
}
